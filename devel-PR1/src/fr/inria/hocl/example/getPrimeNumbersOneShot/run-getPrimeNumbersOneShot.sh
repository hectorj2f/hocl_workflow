#!/bin/bash
java -classpath /usr/lib/hocl/hocl.jar:/home/hfernand/nouveauCompilateur/hocl/branches/devel-PR1/src/fr/inria/hocl/example/getPrimeNumbersOneShot/bin:/home/hfernand/nouveauCompilateur/hocl/branches/devel-PR1/src/fr/inria/hocl/example/getPrimeNumbersOneShot/. fr.inria.hocl.example.getPrimeNumbersOneShot.RunGetPrimeNumbersOneShot_gen;
exit $?;
