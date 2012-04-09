package test.datatypes.records;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.techventus.server.voice.datatypes.records.TranscriptElement;

/**
 * @author bFutral
 * 
 */
public class TranscriptElementTest {

	TranscriptElement testElement;

	String html = "<span id=\"testID\" class=\"gc-word-high\">testText</span>";
	String html1 = "<span id=\"testID\" class=\"gc-word-med1\">testText</span>";
	String html2 = "<span id=\"testID\" class=\"gc-word-med2\">testText</span>";
	String html3 = "<span id=\"testID\" class=\"gc-word-bloop\">testText</span>";
	String html4 = "<span id=\"testID\">testText</span>";

	final TranscriptElement.RecognitionLevel testHigh = TranscriptElement.RecognitionLevel.HIGH;
	final TranscriptElement.RecognitionLevel testMed1 = TranscriptElement.RecognitionLevel.MED1;
	final TranscriptElement.RecognitionLevel testMed2 = TranscriptElement.RecognitionLevel.MED2;
	final TranscriptElement.RecognitionLevel testUnkown = TranscriptElement.RecognitionLevel.UNKNOWN;

	@Before
	public void setUp() {
		testElement = new TranscriptElement("testText", "testID", testHigh);
	}

	@Test
	public void testExtractTransscriptElementHigh() {

		@SuppressWarnings("static-access")
		final TranscriptElement tElementHIGH = testElement
				.extractTransscriptElement(html);

		Assert.assertEquals(testElement.getId(), tElementHIGH.getId());
		Assert.assertEquals(testElement.getText(), tElementHIGH.getText());
		Assert.assertEquals(testElement.getLevel(), tElementHIGH.getLevel());
	}

	@Test
	public void testExtractTransscriptElementMED1() {
		testElement.setLevel(testMed1);
		@SuppressWarnings("static-access")
		final TranscriptElement tElementMED1 = testElement
				.extractTransscriptElement(html1);

		Assert.assertEquals(testElement.getId(), tElementMED1.getId());
		Assert.assertEquals(testElement.getText(), tElementMED1.getText());
		Assert.assertEquals(testElement.getLevel(), tElementMED1.getLevel());
	}

	@Test
	public void testExtractTransscriptElementMED2() {
		testElement.setLevel(testMed2);
		@SuppressWarnings("static-access")
		final TranscriptElement tElementMED2 = testElement
				.extractTransscriptElement(html2);

		Assert.assertEquals(testElement.getId(), tElementMED2.getId());
		Assert.assertEquals(testElement.getText(), tElementMED2.getText());
		Assert.assertEquals(testElement.getLevel(), tElementMED2.getLevel());
	}

	@Test
	public void testExtractTransscriptElementUnknown() {
		testElement.setLevel(testUnkown);
		@SuppressWarnings("static-access")
		final TranscriptElement tElementUnknown = testElement
				.extractTransscriptElement(html3);

		Assert.assertEquals(testElement.getId(), tElementUnknown.getId());
		Assert.assertEquals(testElement.getText(), tElementUnknown.getText());
		Assert.assertEquals(testElement.getLevel(), tElementUnknown.getLevel());
	}

	@Test
	public void testExtractTransscriptElementNull() {
		@SuppressWarnings("static-access")
		final TranscriptElement tElementNull = testElement
				.extractTransscriptElement(html4);

		Assert.assertNull(tElementNull);
	}

}
