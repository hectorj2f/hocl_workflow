#!/bin/bash
java -classpath /usr/lib/hocl/hocl.jar:/home/hfernand/nouveauCompilateur/hocl/branches/devel-PR1/src/fr/inria/hocl/example/getPrimeNumbers/bin:/home/hfernand/nouveauCompilateur/hocl/branches/devel-PR1/src/fr/inria/hocl/example/getPrimeNumbers/. fr.inria.hocl.example.getPrimeNumbers.RunGetPrimeNumbers_gen;
exit $?;
