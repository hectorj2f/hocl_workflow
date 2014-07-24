#!/bin/bash
java -classpath /usr/lib/hocl/hocl.jar:/home/hfernand/nouveauCompilateur/hocl/branches/devel-PR1/src/fr/inria/hocl/tests/ho_rule01_test02/bin:/home/hfernand/nouveauCompilateur/hocl/branches/devel-PR1/src/fr/inria/hocl/tests/ho_rule01_test02/. fr.inria.hocl.tests.ho_rule01_test02.RunHo_rule01_test02_gen;
exit $?;
