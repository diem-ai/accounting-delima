#### The idea is to find a subset populated from a BigDecial array which is created from a input text file by searching will be terminated if subtraction between given value and each item in subset is zero.
#### The explanation can be found more detail in comments at the head of java classes.
-  Main class is ValidationTest.java 
- To execute find-payments.jar:
Go to console windows -> cd to /AccountingDelima -> perform command: java -jar find_payments.jar <text file name>

- The project structure:

AccountingDelima
/src
  |__code
     |__DataProcessing.jaba
     |__IDataProcessing.jaba
     |__FindPayments.java
  |__test
     |__AllUnitTests.java
     |__JUnitTest_DataProcessing
     |__JUnitTest_FindPayments.java
     |__ValidationTest.java     
/reources
     |__input.txt
     |__input2.txt
     |__testEmptyInput.txt
/find_payments.jar
/README
