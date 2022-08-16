package com.example.java13;

public class Exercise1 {
	private static final String SELECT_CUSTOMERS_BY_IDENTITY = 
			"""
            SELECT IDENTITY, FULLNAME, EMAIL, PHONE
            FROM CUSTOMERS
            WHERE IDENTITY=?
            """;
	private static final String JACK_AS_JSON = """
            {
                "identity": "12345678910",
                "fullname": "jack bauer",
                "email": "jack.bauer@ctu.gov",
                "phone" : "555-555-5555"
            }
            """;	
    private static final String JACK_AS_XML = """
            <?xml version="1.0"?>
            <customers>
                <customer identity="12345678910">
                    <fullname>jack bauer</fullname>
                    <email>jack.bauer@ctu.gov</email>
                    <phone>555-555-5555</phone>
                </customer>
            </customers>
            """;
	public static void main(String[] args) {
        System.out.println(SELECT_CUSTOMERS_BY_IDENTITY);
        System.out.println(JACK_AS_JSON);
        System.out.println(JACK_AS_XML);
	}

}
