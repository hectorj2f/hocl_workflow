#!/bin/bash
java -classpath /usr/lib/hocl/hocl.jar:/home/hfernand/nouveauCompilateur/hocl/branches/devel-PR1/src/fr/inria/hocl/tests/ho_rule01_test01/bin:/home/hfernand/nouveauCompilateur/hocl/branches/devel-PR1/src/fr/inria/hocl/tests/ho_rule01_test01/. fr.inria.hocl.tests.ho_rule01_test01.RunHo_rule01_test01_gen;
exit $?;
