package fr.inria.hocl.core.hocli;

public class StrategyFairRoundRobin
  implements Strategy
{
  private SimpleLinkedList<ReactionRule> rules;
  private SimpleIterator<ReactionRule> it_currentRule;
  private boolean firstCalled;
  private boolean foundReaction;

  public StrategyFairRoundRobin()
  {
    this.rules = new SimpleLinkedList();
    this.it_currentRule = this.rules.newIterator();
    this.firstCalled = false;
    this.foundReaction = false;
  }

  public void manageSolution(Solution solution)
  {
    solution.addObserverAdd(this);
    SimpleIterator it = solution.newIterator();
    while (!it.isAtEnd()) {
      notifyAdd(solution, (Atom)it.getElement());
      it.next();
    }
  }

  public ReactionRule firstRule()
  {
    this.firstCalled = true;
    this.foundReaction = false;
    ReactionRule rr;
      if (this.rules.isEmpty()) {
      rr = null;
    } else {
      this.it_currentRule.moveToBeginning();
      rr = (ReactionRule)this.it_currentRule.getElement();
    }
    return rr;
  }

  public ReactionRule queryNextRule(boolean previousHasReacted)
  {
    assert (this.firstCalled);

    if (previousHasReacted) {
      this.foundReaction = true;
    }
    this.it_currentRule.next();
    if (this.it_currentRule.isAtEnd()) {
      if (this.foundReaction) {
        return firstRule();
      }
      return null;
    }

    return (ReactionRule)this.it_currentRule.getElement();
  }

  public void notifyAdd(Solution solution, Atom atom)
  {
    if ((atom instanceof ReactionRule))
      this.rules.add((ReactionRule)atom);
  }

  public void notifyRemove(Solution solution, Atom atom)
  {
    if ((atom instanceof ReactionRule))
      if (this.it_currentRule.getElement() == atom) {
        this.it_currentRule.remove();
        this.it_currentRule.previous();
      }
      else {
        this.rules.remove((ReactionRule)atom);
      }
  }

  public String getStat()
  {
    String s = new String();

    SimpleIterator it_rr = this.rules.newIterator();
    while (!it_rr.isAtEnd()) {
      s = s + ((ReactionRule)it_rr.getElement()).getStat();
      it_rr.next();
    }
    return s;
  }

  public String toString()
  {
    return "Fair Round Robin that manages " + this.rules;
  }
}