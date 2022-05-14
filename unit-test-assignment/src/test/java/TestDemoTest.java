import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
class TestDemoTest {

	
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a , int b, int expected, boolean expectException) {
	TestDemo testDemo = new TestDemo();
	
	if(!expectException) {
		assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
	}
	else {
		assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
	}
	}
	@Test
	void assertThatNumberSquaredIsCorrect() { 
		TestDemo testDemo = new TestDemo();
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(25).when(mockDemo).getRandomInt();
		assertThat(mockDemo.generateRandomPositiveInteger()).isEqualTo(0);
	}
	
	
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream
				.of(//@formatter:off
						arguments(2, 4, 6, false),
						arguments(1, -2, -1, true),
						arguments(1, 0, 1, true),
						arguments(-1, -1, -2, true),
						arguments(1, 1, 2, false)
						//formatter:on
						);
	}

	}



