javac -d bin -cp lib\* -sourcepath src test\myTests\ScramblerTest.java
java -cp bin;lib\* org.junit.runner.JUnitCore myTests.ScramblerTest
PAUSE