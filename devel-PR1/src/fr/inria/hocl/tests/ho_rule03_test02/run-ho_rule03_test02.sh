#!/bin/bash
java -classpath /usr/lib/hocl/hocl.jar:/home/hfernand/nouveauCompilateur/hocl/branches/devel-PR1/src/fr/inria/hocl/tests/ho_rule03_test02/bin:/home/hfernand/nouveauCompilateur/hocl/branches/devel-PR1/src/fr/inria/hocl/tests/ho_rule03_test02/. fr.inria.hocl.tests.ho_rule03_test02.RunHo_rule03_test02_gen;
exit $?;
