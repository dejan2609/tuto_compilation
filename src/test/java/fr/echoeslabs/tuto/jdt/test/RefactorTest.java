package fr.echoeslabs.tuto.jdt.test;

import java.io.File;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Test;

import fr.echoeslabs.tuto.jdt.refactoring.MethodInvocationCamelCaseRefactoring;
import fr.echoeslabs.tuto.jdt.refactoring.MethodNameCamelCaseRefactoring;
import fr.echoeslabs.tuto.jdt.refactoring.NoChangeRefactoring;
import fr.echoeslabs.tuto.jdt.refactoring.SwitchOrderingRefactoring;
import fr.echoeslabs.tuto.jdt.refactoring.api.RefactoringException;
import fr.echoeslabs.tuto.jdt.util.JavaUtils;

public class RefactorTest extends AbstractRefactoringTest {

	@Test
	public void testSample1() throws RefactoringException {
		final String inputJavaFilePath = "src/test/resources/java_input/Sample1.java";
		final File inputJavaFile = new File(inputJavaFilePath);

		final CompilationUnit parseOriginalAST = JavaUtils.parse(inputJavaFile);
		this.performTest(NoChangeRefactoring.class, inputJavaFile, parseOriginalAST.toString());
	}

	@Test
	public void testCamelCaseRefactoring() throws RefactoringException {
		final String inputJavaFilePath = "src/test/resources/java_input/CamelCaseRefactoring/Sample2.java";
		final String exptectedJavaFilePath = "src/test/resources/java_input/CamelCaseRefactoring/Sample2.java.expected";
		final String outputJavaFilePath = "src/test/resources/java_input/CamelCaseRefactoring/Sample2.java.output";

		this.setOutputFilePath(outputJavaFilePath);
		this.setExpectedFilePath(exptectedJavaFilePath);
		this.performFileTest(MethodNameCamelCaseRefactoring.class, inputJavaFilePath);
	}

	@Test
	public void testMethodInvocationToCamelCaseRefactoring() throws RefactoringException {
		final String inputJavaFilePath = "src/test/resources/java_input/CamelCaseRefactoring/Exercise1.java";
		final String exptectedJavaFilePath = "src/test/resources/java_input/CamelCaseRefactoring/Exercise1.java.expected";
		final String outputJavaFilePath = "src/test/resources/java_input/CamelCaseRefactoring/Exercise1.java.output";

		this.setOutputFilePath(outputJavaFilePath);
//		this.setExpectedFilePath(exptectedJavaFilePath);
		this.performFileTest(MethodInvocationCamelCaseRefactoring.class, inputJavaFilePath);

	}

	@Test
	public void testSwitchOrderingRefactoring() throws RefactoringException {
		final String inputJavaFilePath = "src/test/resources/java_input/SwitchOrdering/Exercise2.java";
		final String exptectedJavaFilePath = "src/test/resources/java_input/SwitchOrdering/Exercise2.java.expected";
		final String outputJavaFIlePath = "src/test/resources/java_input/SwitchOrdering/Exercise2.java.output";

		this.setOutputFilePath(outputJavaFIlePath);
//		this.setExpectedFilePath(exptectedJavaFilePath);
		this.performFileTest(SwitchOrderingRefactoring.class, inputJavaFilePath);

	}
}
