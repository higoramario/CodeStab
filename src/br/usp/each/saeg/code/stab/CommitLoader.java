package br.usp.each.saeg.code.stab;

import java.util.ArrayList;
import java.util.List;

public class CommitLoader {
	
	public static List<String> guavaCommits(){
		List<String> guava = new ArrayList<String>();
		guava.add("545da1dd55a20982645f365f2f30b53ce52af39b");
		guava.add("bb7a1ce573a6da955e095869bd3e06cb1449ae9e");
		guava.add("cfc06d3d2f2eec021b6d58d0c50e6884a4b63869");
		guava.add("a5b1ce806d6b6e9271debc430d335638bbb327e9");
		guava.add("a2fde5411366a29259483c521955ef1fdcef280b");
		guava.add("7037b865b955e0bbe697e735ed62d644d3a6ff01");
		guava.add("2ee69f587c4285cbb80f40d0d81c517d4778878c");
		guava.add("276bd8045c98935858ff068cd64dd07a7dc42fc0");
		guava.add("ac083ab0599d9b3b4a59191b397e1da8fc39a99f");
		guava.add("919ffc3d617df7d049e8754ae62373166f879b2e");
		guava.add("6ff77cf5941d5caac9672ce148ae6f7ab67cf144");
		guava.add("04ed59121f88861eb24d59de0a0c66aa5400c748");
		guava.add("1a1b97ee1f065d0bc52c91eeeb6407bfaa6cbea1");
		guava.add("49d8026ac5cc8d1d0acd4bd79f0a22f5b8fcb8cf");
		guava.add("3a604328c28919480caea60e754debb8ec84b75b");
		guava.add("5e4e5eee5d5df8804db49ddc596682e7910220b8");
		return guava;
	}
	
	public static List<String> guavaTestPatterns(){
		List<String> testPatterns = new ArrayList<String>();
		testPatterns.add("/test/");
		testPatterns.add("/testing/");
		testPatterns.add("guava-tests/");
		testPatterns.add("*Test.java");
		testPatterns.add("/Test*");
		testPatterns.add("/test-super/");
		testPatterns.add("*Test.java");
		testPatterns.add("*Tester.java");
		testPatterns.add("guava-teslib/");
		return testPatterns;
	}
	
	public static List<String> hadoopCommits(){
		List<String> hadoop = new ArrayList<String>();
		hadoop.add("22a9a6b0d412f31ea0f15ac389e56b9de9eeadb1");
		hadoop.add("5b4a708704b7f6172f087d6cfe43114dfab57f53");
		hadoop.add("da6f1b88dd47e22b24d44f6fc8bbee73e85746f7");
		hadoop.add("0a5def155eff4564b5dc7685e7460952f51bbd24");
		hadoop.add("01643020d24b606c26cb2dcaefdb6e47a5f06c8f");
		hadoop.add("6161d9ba5230f553db5f5490dce67e2afd1e29ca");
		hadoop.add("63e5412f1aef5e17e15da69d646181c629fc8682");
		hadoop.add("a7d8f2b3960d27c74abb17ce2aa4bcd999706ad2");
		hadoop.add("27b77751c1163ab4a1ce081a426e5190d1b8aff4");
		hadoop.add("618bfd6ac2a5b62d39e9bed80f75362bafc0ef28");
		hadoop.add("df83230948204ee2d2b06ecc66ce0163e2df27ef");
		hadoop.add("817ae221ac1ca8552748f6310d29ea1b26b5a21b");
		hadoop.add("124a412a3711bd42eaeebe531376004c739a15d6");
		hadoop.add("7c5c099324d9168114be2f1233d49fdb65a8c1f2");
		hadoop.add("37e1c3d82a96d781e1c9982988b7de4aa5242d0c");
		hadoop.add("ee98d6354bbbcd0832d3e539ee097f837e5d0e31");
		return hadoop;
	}
	
	public static List<String> hadoopTestPatterns(){
		List<String> testPatterns = new ArrayList<String>();
		testPatterns.add("/test/");
		testPatterns.add("/Test");
		return testPatterns;
	}
	
	public static List<String> jenaCommits(){
		List<String> jena = new ArrayList<String>();
		jena.add("a3d65142f4328a277df60fa6052fec667febb47f");
		jena.add("807e8ff776da047014f67696338c987dbd2c5746");
		jena.add("145b7139ac1024fb6007c130ca12494bedad297d");
		jena.add("dea868fe46b6cc6c1a298b67f1a2067876729dbc");
		jena.add("c5bf5c5eb503f09c512582e5a6e5806a3829e7b1");
		jena.add("e8867ad1b64f0d2e76a92cce8a5d6d45120b85a1");
		jena.add("316772ceed81ae4f2eddc9ef83a68a47ea99dfa3");
		jena.add("1132a36bd808288bb9dc3f53a193c86fccb511b9");
		jena.add("11edc56e53950a0826a89b143f965abb762ac027");
		jena.add("daccd68099beb8be98aabb9d7dd8433b1e307d10");
		jena.add("e70adf702c2045aad319db21c7950f5ab724b911");
		jena.add("7825df2366c4cd60f406b1c4a8e8222948891184");
		jena.add("3437e9e78e84849e83b5159d6a66739cf39383d6");
		jena.add("59d5070255e45d488cacf49eec0923b199cbd141");
		jena.add("75a7a77c9a92662a88c62dca5d80f85c1c478b78");
		jena.add("1dd6cfd1b9b1457af7a7942cd9912c75852c1280");
		return jena;
	}
	
	public static List<String> jenaTestPatterns(){
		List<String> testPatterns = new ArrayList<String>();
		testPatterns.add("/test/");
		testPatterns.add("*Test.java");
		testPatterns.add("*Tests.java");
		testPatterns.add("-test");
		testPatterns.add("/Test");
		testPatterns.add("/testing/");
		testPatterns.add("AbstractTest");
		return testPatterns;
	}
	
	public static List<String> kafkaCommits(){
		List<String> kafka = new ArrayList<String>();
		kafka.add("fa32545442ef6724aa9fb5f4e0e269b0c873288f");
		kafka.add("7a70c1a1087ca78d5e6db3908f6d6b6b19e8aaab");
		kafka.add("0edaa89be35ad427b848e0d91164422871853640");
		kafka.add("2098529b44cad78731e478aa8af2b49e9c94db7d");
		kafka.add("36cab7dbdff6981d0df4b355dadee3fac35508a6");
		kafka.add("dee38806663b0062706dfaca40da9537792f05a9");
		kafka.add("bc5051565171cf65b4ed7dd4d9ef269d66a1021a");
		kafka.add("255b5e13863a95cfc327236856db2df188f04d49");
		kafka.add("68af16ac15e5675daebb710ed8f15f780dc43abd");
		kafka.add("bc9237701b06768c119e954ddb4cd2e61c24e305");
		kafka.add("83d4c359bab40ce7418cd5f7219a23a9fcfba921");
		kafka.add("84c8d2bb86dc2794a3d6a86ae28b3cb51cea5c4b");
		kafka.add("65922b5388561e3ab830fd1f367faa289d205e2a");
		kafka.add("4833d8a8c34b2fb86a5cf605ea5483d0b9eadc4f");
		kafka.add("6acd37720df402a665094ba1153ae200ad5d6705");
		kafka.add("2040890462a22614ccb836e43837f8739855b84f");
		return kafka;
	}
	
	public static List<String> kafkaTestPatterns(){
		List<String> testPatterns = new ArrayList<String>();
		testPatterns.add("/test/");
		testPatterns.add("*Test.java");
		testPatterns.add("/Test");
		testPatterns.add("tests/");
		return testPatterns;
	}
	
	
	public static List<String> elasticSearchCommits(){
		List<String> elasticsearch = new ArrayList<String>();
		elasticsearch.add("d4366f8493ac8d2f7091404ffd346e4f3c0f9af9");
		elasticsearch.add("dddbe4acade78dc408278a1e9b6f42ec86b1f204");
		elasticsearch.add("2b9d4bdf857f1b70a9e1c69c4b7347ce28a1fff5");
		elasticsearch.add("5a66c08ae9b6348dbeb47870e25faa561a14aa9a");
		elasticsearch.add("157645fe9e2c677d19f688cdf24b3e288b70f9cb");
		elasticsearch.add("89a57bce5aefcdc6be80bcc35e3bc93d1c2d6559");
		elasticsearch.add("034adeb94748a7b99a3fffa3090e9e9d8f7cde5b");
		elasticsearch.add("1dff3a82105ea5c91c9a87989750700456032b5d");
		elasticsearch.add("a9eb668497dc7d4da80f8de806f230eacf3de819");
		elasticsearch.add("b349746bbe6767b527d9410f3d6faa0313b377f4");
		elasticsearch.add("862cdad8dc3bf82f5d0bbc8bcd8742855ca69929");
		elasticsearch.add("503d836ee405ac6f49b9cfcf6890dc6a01db0fcf");
		elasticsearch.add("d8dcf7b81e1910738ccc6a75060232f348a0ed0b");
		elasticsearch.add("cfb1e6c6c24570a7c7ef791c48d39ecdeab558eb");
		elasticsearch.add("345b2b98cfa5af1900b65ba62835f64af025fbea");
		elasticsearch.add("ed1642b9683060fab4d8d549ab4e5b012e0e3b83");
		return elasticsearch;
	}
	
	public static List<String> elasticSearchTestPatterns(){
		List<String> testPatterns = new ArrayList<String>();
		testPatterns.add("/test/");
		testPatterns.add("test/");
		testPatterns.add("/Test");
		testPatterns.add("*Test.java");
		testPatterns.add("*Tests.java");
		testPatterns.add("*TestCase.java");
		testPatterns.add("*TestSuite*");
		testPatterns.add("*TestSuiteIT.java");
		return testPatterns;
	}
	
	
	public static List<String> cassandraCommits(){
		List<String> cassandra = new ArrayList<String>();
		cassandra.add("8d317b1d305e173cd432518218e38d3cc9e6fc5e");
		cassandra.add("f6ca482516d3915b9a0b87a787d0c7893e39c92b");
		cassandra.add("09720f81d9185a3e4c355f9cfb7db439561b1e3c");
		cassandra.add("f542a2ea6e72e359e882be69d454f4e55680ad66");
		cassandra.add("82ef1cfc3d5a62c4d0f6163e09a9690b43959a92");
		cassandra.add("74f41c9cc61959748aa2cb6b42186ecfd8587796");
		cassandra.add("c83729f41d358ce3ca2ac0323704ef516dff9298");
		cassandra.add("e24da8f7faea0e764ab4653343085adf6edcd75f");
		cassandra.add("aca2a1dcfdc5210a68ea13affdd819f8f4108a54");
		cassandra.add("ee5aec2d2ed7795d64a052e191af4aec5c807dba");
		cassandra.add("7e47377164949d23a468cf012736efb96f1e7dcc");
		cassandra.add("8c511cc45e28118447443935d95b0a96d64cbece");
		cassandra.add("5dd2247dd8e2bcd4ccff04c9d3b236b354184c46");
		cassandra.add("e75ebc4f6b92013f92d93abb56d1c1325d4f2c15");
		cassandra.add("e93977310877595e50a8555a4a3322f29a3e3485");
		cassandra.add("8d7c608bac9440911f4803db04f306f0616f2a22");
		return cassandra;
	}
	
	public static List<String> cassandraTestPatterns(){
		List<String> testPatterns = new ArrayList<String>();
		testPatterns.add("/test/");
		testPatterns.add("test/");
		testPatterns.add("*Test.java");
		testPatterns.add("*Tester.java");
		return testPatterns;
	}
	
	public static List<String> groovyCommits(){
		List<String> groovy = new ArrayList<String>();
		groovy.add("2c226838ed69685919ddfb0f1efb72fa92875b76");
		groovy.add("07564a3f9c6ab6dc49e726942ce40473ef544b16");
		groovy.add("380ae614ae4d979f00e6e362d210e2dd1295bdce");
		groovy.add("e9417a4ccd16d3038713e1b4db7a0db91d313c93");
		groovy.add("8bcca9ef2e2b35b25c396e66dfefe9255911a4c5");
		groovy.add("ff2383816bd184036cab1c1d7672ea29f09e02dc");
		groovy.add("1c001704a2ec3bd1a1ded612b9ae645dee7ad2af");
		groovy.add("bd020b5e9938b13cf4dfb5de19489c7c923eda09");
		groovy.add("795667abe48d712393ce9f0650ce7b53b0ee243e");
		groovy.add("bdaef2a1539d3b3d0a9a5fa549ddd7421673797f");
		groovy.add("c90de50c412423829f9abaa2489166d72cefa2af");
		groovy.add("a38afed6f9189e4b96cfd25876324de41b5dd559");
		groovy.add("636595690824b7567d5aa8ce2c34419fe0b4d50b");
		groovy.add("8e9716256b95ee9a8e0c902cd49a22f4fe411137");
		groovy.add("f6ade7132789c6151dda36278b5435c5c71fff73");
		groovy.add("5a7afe389fd38bc83965651aafe46cc9f9dabbb2");
		return groovy;
	}
	
	public static List<String> groovyTestPatterns(){
		List<String> testPatterns = new ArrayList<String>();
		testPatterns.add("/test/");
		testPatterns.add("*/Test");
		testPatterns.add("*Test.java");
		testPatterns.add("*TestBase.java");
		testPatterns.add("*TestData.java");
		testPatterns.add("test-fixtures/");
		testPatterns.add("test-resources/");
		testPatterns.add("groovy-test/");
		testPatterns.add("groovy-testng/");
		return testPatterns;
	}
	
	public static List<String> jmeterCommits(){
		List<String> jmeter = new ArrayList<String>();
		jmeter.add("c6d4876694d0680a92cf15af09f6cfe9728733e9");
		jmeter.add("fcadd988d536bfa944edec7da33548498746b87d");
		jmeter.add("72ea0ff6850bcbb6095991595aa2e3a6ae2601db");
		jmeter.add("15f3badc843ae01af563f1dc14abb7d15543d1ad");
		jmeter.add("42ccc4985f2aac6d3db109065ce9bbcf9c3be559");
		jmeter.add("b1bf45ef361f0549d439855a90a74b8bf24a84a8");
		jmeter.add("88db986dd39f43de46a98b30aeeba4b33ebcc50e");
		jmeter.add("ca42b238bd7e3d55722a3241a34de6045625242e");
		jmeter.add("c839b48cc09d4e8bc15dd28e19013eb73507f272");
		jmeter.add("7cea61070aa4db47eb2d968e177697397a2206a4");
		jmeter.add("fe2f082f70c601d7f3ca0f98640b006557800d1e");
		jmeter.add("d8624652c21bcc746f619bf6edde7268f31dcb6e");
		jmeter.add("b557b9325c9e6fb124d54d6c0f9ba37f8321744e");
		jmeter.add("0358450978303407ed2b7a16813af705e7626f23");
		jmeter.add("6e95287d4a9be58d40dcdbbc3a83f9241446eee7");
		jmeter.add("8891d2b5c1542580351141b4e4e1173ad5da8fc0");
		return jmeter;
	}
	
	public static List<String> jmeterTestPatterns(){
		List<String> testPatterns = new ArrayList<String>();
		testPatterns.add("/test/");
		testPatterns.add("/Test*");
		testPatterns.add("*Test.java");
		testPatterns.add("*TestElement.java");
		testPatterns.add("*TestCase.java");
		testPatterns.add("*Tests.java");
		testPatterns.add("test/");
		testPatterns.add("/testbeans/");
		testPatterns.add("/testelement/");
		return testPatterns;
	}
	
	public static List<String> tomcatCommits(){
		List<String> tomcat = new ArrayList<String>();
		tomcat.add("b93fa63eade1deee9594d7ad3e372ea835ff99c1");
		tomcat.add("92dfb0d47b14960385437bd93ac73380553608af");
		tomcat.add("628c21b1c12be3dc4d2b8b44a5ed03ea71d223e0");
		tomcat.add("0c1cf8f2cd53dac303e6cbcfcb6fdab1015f57b0");
		tomcat.add("a9870552bed76b4562901422b9cc56a9f524a07d");
		tomcat.add("5a2dc22e6dd3ad7b86a761e91f43b16c0261f23d");
		tomcat.add("b914d9892de88bfd3045333b1719186211dc3be6");
		tomcat.add("1b0976942f269b82c6cf69ff760cc80f3cd9cd2e");
		tomcat.add("58ad1994cb8ddec2f0e2092d02fe3564e5ff3fe1");
		tomcat.add("b2c178b0a78d9b6f71df17cc8b7adfef93c9a295");
		tomcat.add("85dd574dcb7dd232c903f52b97a6464d1ca0cd43");
		tomcat.add("63d4655906f51703e78f137e3a33f49218bf88f1");
		tomcat.add("a8906842f99e1d78f6d7190e5539040b6c27f8ac");
		tomcat.add("1251efbc0481a420c28fe2d6a77f943589e389bb");
		tomcat.add("4f71a568d7d6cad32424a380ab86ab7ee3b0d39e");
		tomcat.add("8287fc305224f499035e29447ce15e407fd4a19d");
		return tomcat;
	}
	
	public static List<String> tomcatTestPatterns(){
		List<String> testPatterns = new ArrayList<String>();
		testPatterns.add("/test/");
		testPatterns.add("*Test.java");
		testPatterns.add("/Test*");
		testPatterns.add("test/");
		return testPatterns;
	}
	
	public static List<String> qpidCommits(){
		List<String> qpid = new ArrayList<String>();
		qpid.add("8c49f88914ffaaf66d3caba24ae4f7392dfc0caa");
		qpid.add("f8517fa3558cbd64104edd0e40dea7706b4fe25f");
		qpid.add("1f9ad64ec019e9aa2e8ee26654b7ea9609096fda");
		qpid.add("1df7a9fa20c2e26723f0a2ff312f60c2c05ceae1");
		qpid.add("7dd8c63f6f993f8997bd0a4355dd622c07ee2cf0");
		qpid.add("bf4f5eed8adaf3f48673514ca87e44cfdad4ddca");
		qpid.add("34aa9b60672026ce1883371c9ca1c6c64d107503");
		qpid.add("1b93f55c9de0c921fc8cc9c9406e3b9752bea9a5");
		qpid.add("782015df3fc1cfc10a2fc2406199cc8a1ac79edd");
		qpid.add("66b20a567754d7bae7c2b82cd1456b71248993d3");
		qpid.add("fa3e4cef169e0cb0cba92da2c4116e99a66bfa9e");
		qpid.add("1d74eed7c146c0e14ddaa7c4c668c0d85c2e06cb");
		qpid.add("e1a26d0bb4743405efde4d59786ce9317d9f8b89");
		qpid.add("5e4ef44c8a4516ae5dd348f925a97ebda6f52a82");
		qpid.add("610d25709f0842a4e45542f3ed6bc8b2217590e6");
		qpid.add("02753a65002af1aa85488dd17b95b9e20e9deddc");
		return qpid;
	}
	
	public static List<String> qpidTestPatterns(){
		List<String> testPatterns = new ArrayList<String>();
		testPatterns.add("/test/");
		testPatterns.add("*Test.java");
		testPatterns.add("/Test*");
		testPatterns.add("test/");
		testPatterns.add("/systests/");
		return testPatterns;
	}
	
	public static List<String> cheCommits(){
		List<String> che = new ArrayList<String>();
		che.add("6178cc65665e46edb4b8f71bab6d08d0bcdff2f6");
		che.add("cf4cf3e9a8f9529d6c4694c18a764de72ad46bb8");
		che.add("391ab1eb25ed39da0400835f386506d1a43dbd30");
		che.add("7d6739329d7fb800fab2f4d4909f5c2366211e50");
		che.add("5c27745b85c5a7e557946dff77a37483c18f4856");
		che.add("33b3c912aa48c1e85d98a49e865d5e763cb5f342");
		che.add("b0049aab30e1ae8c1243ea20b8664c96ad75d624");
		che.add("cb3be2e3baf16f3fc4614fbcd4b0590fd9769aad");
		che.add("a38525f11846aabc864be6dbf0951786a542fd44");
		che.add("d557e732fa04c9ec98c4cb87d91b13c9c5bcb120");
		che.add("bebeda6c69e57fe26416ca8da97be5d8022fc062");
		che.add("3baea928f6af7c57004650ee4f7a8637d6b21fb5");
		return che;
	}
	
	public static List<String> cheTestPatterns(){
		List<String> testPatterns = new ArrayList<String>();
		testPatterns.add("/test/");
		testPatterns.add("*Test.java");
		testPatterns.add("/Test*");
		testPatterns.add("test/");
		return testPatterns;
	}
	
	public static List<String> vraptor4Commits(){
		List<String> vraptor4 = new ArrayList<String>();
		vraptor4.add("2f1b8f45be0e2e1b2b05ee93d1407056623435cf");
		vraptor4.add("aff259d10de28ab855f16fbd8e7482badc0ed44c");
		vraptor4.add("8a9b099aa46254931008f61ae85be7a2ef0cf5c1");
		vraptor4.add("a9f3600dc071969b026aaec527e574aa3d9742a0");
		vraptor4.add("803842f0857d2909db463b7649e7b2ef73ef4d1b");
		vraptor4.add("2b0d7ddc0baa9a8f04113aee33a45b6795fb5e26");
		vraptor4.add("e62f252219d3bb6ad8090581d9f4f704a0cc16b5");
		vraptor4.add("9c1ee3e9b0007321e7fa02073d9b47129ad6e233");
		vraptor4.add("0809ce5f696bc0922d6a2c1aae20b68e1711e9be");
		vraptor4.add("ceae65125e2bead2b1a0df62e81b281b0d9305e5");
		vraptor4.add("659633b75ccc3612450d8b79d53c2a36819a3b9a");
		vraptor4.add("117aac028bfc9db300f0d2c746e5d3b3589f2338");
		vraptor4.add("e04d5f4bdfd6d38d27bc16f4010debccc08772e8");
		vraptor4.add("4641e57606be1ed1fa4af2bc17b6b61630d6462d");
		vraptor4.add("375936936af013db762f221c576373ff479d511c");
		vraptor4.add("eb11dc3033b11b224c30f269e16607fef51b4514");
		return vraptor4;
	}
	
	public static List<String> vraptor4TestPatterns(){
		List<String> testPatterns = new ArrayList<String>();
		testPatterns.add("/test/");
		testPatterns.add("*Test.java");
		testPatterns.add("*TestCase.java");
		testPatterns.add("/Test*");
		testPatterns.add("test/");
		return testPatterns;
	}
	
}
