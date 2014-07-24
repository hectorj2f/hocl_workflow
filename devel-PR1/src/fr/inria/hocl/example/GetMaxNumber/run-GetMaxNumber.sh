#!/bin/bash
java -classpath /usr/lib/hocl/hocl.jar:/home/hfernand/nouveauCompilateur/hocl/branches/devel-PR1/src/fr/inria/hocl/example/GetMaxNumber/bin:/home/hfernand/nouveauCompilateur/hocl/branches/devel-PR1/src/fr/inria/hocl/example/GetMaxNumber/. fr.inria.hocl.example.GetMaxNumber.RunGetMaxNumber_gen;
exit $?;
