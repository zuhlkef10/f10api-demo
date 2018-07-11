package com.zuhlke.f10.transaction.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuhlke.f10.transaction.model.Transaction;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TransactionService {

    public Transaction getTransactionById(String bankId, String accountId, String viewId, String transactionId){

        ObjectMapper mapper = new ObjectMapper();
        Transaction transaction = null;

        try {
            String jsonInString="{\n" +
                    "  \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "  \"this_account\":{\n" +
                    "    \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "    \"holders\":[{\n" +
                    "      \"name\":\"OBP\",\n" +
                    "      \"is_alias\":true\n" +
                    "    }],\n" +
                    "    \"number\":\"123\",\n" +
                    "    \"kind\":\"AC\",\n" +
                    "    \"IBAN\":\"UK1234AD\",\n" +
                    "    \"swift_bic\":\"UK1234AD\",\n" +
                    "    \"bank\":{\n" +
                    "      \"national_identifier\":\"OBP\",\n" +
                    "      \"name\":\"OBP\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"other_account\":{\n" +
                    "    \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "    \"holder\":{\n" +
                    "      \"name\":\"OBP\",\n" +
                    "      \"is_alias\":true\n" +
                    "    },\n" +
                    "    \"number\":\"123\",\n" +
                    "    \"kind\":\"3456\",\n" +
                    "    \"IBAN\":\"UK234DB\",\n" +
                    "    \"swift_bic\":\"UK12321DB\",\n" +
                    "    \"bank\":{\n" +
                    "      \"national_identifier\":\"OBP\",\n" +
                    "      \"name\":\"OBP\"\n" +
                    "    },\n" +
                    "    \"metadata\":{\n" +
                    "      \"public_alias\":\"NONE\",\n" +
                    "      \"private_alias\":\"NONE\",\n" +
                    "      \"more_info\":\"www.openbankproject.com\",\n" +
                    "      \"URL\":\"www.openbankproject.com\",\n" +
                    "      \"image_URL\":\"www.openbankproject.com\",\n" +
                    "      \"open_corporates_URL\":\"www.openbankproject.com\",\n" +
                    "      \"corporate_location\":{\n" +
                    "        \"latitude\":1.231,\n" +
                    "        \"longitude\":1.231,\n" +
                    "        \"date\":\"2013-01-22T00:08:00Z\",\n" +
                    "        \"user\":{\n" +
                    "          \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "          \"provider\":\"OBP\",\n" +
                    "          \"display_name\":\"OBP\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      \"physical_location\":{\n" +
                    "        \"latitude\":1.231,\n" +
                    "        \"longitude\":1.231,\n" +
                    "        \"date\":\"2013-01-22T00:08:00Z\",\n" +
                    "        \"user\":{\n" +
                    "          \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "          \"provider\":\"OBP\",\n" +
                    "          \"display_name\":\"OBP\"\n" +
                    "        }\n" +
                    "      }\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"details\":{\n" +
                    "    \"type\":\"AC\",\n" +
                    "    \"description\":\"this is for family\",\n" +
                    "    \"posted\":\"2013-01-22T00:08:00Z\",\n" +
                    "    \"completed\":\"2013-01-22T00:08:00Z\",\n" +
                    "    \"new_balance\":{\n" +
                    "      \"currency\":\"EUR\",\n" +
                    "      \"amount\":\"10\"\n" +
                    "    },\n" +
                    "    \"value\":{\n" +
                    "      \"currency\":\"EUR\",\n" +
                    "      \"amount\":\"10\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"metadata\":{\n" +
                    "    \"narrative\":\"NONE\",\n" +
                    "    \"comments\":[{\n" +
                    "      \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "      \"value\":\"OBP\",\n" +
                    "      \"date\":\"2013-01-22T00:08:00Z\",\n" +
                    "      \"user\":{\n" +
                    "        \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "        \"provider\":\"OBP\",\n" +
                    "        \"display_name\":\"OBP\"\n" +
                    "      }\n" +
                    "    }],\n" +
                    "    \"tags\":[{\n" +
                    "      \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "      \"value\":\"OBP\",\n" +
                    "      \"date\":\"2013-01-22T00:08:00Z\",\n" +
                    "      \"user\":{\n" +
                    "        \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "        \"provider\":\"OBP\",\n" +
                    "        \"display_name\":\"OBP\"\n" +
                    "      }\n" +
                    "    }],\n" +
                    "    \"images\":[{\n" +
                    "      \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "      \"label\":\"NONE\",\n" +
                    "      \"URL\":\"www.openbankproject.com\",\n" +
                    "      \"date\":\"2013-01-22T00:08:00Z\",\n" +
                    "      \"user\":{\n" +
                    "        \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "        \"provider\":\"OBP\",\n" +
                    "        \"display_name\":\"OBP\"\n" +
                    "      }\n" +
                    "    }],\n" +
                    "    \"where\":{\n" +
                    "      \"latitude\":1.231,\n" +
                    "      \"longitude\":1.231,\n" +
                    "      \"date\":\"2013-01-22T00:08:00Z\",\n" +
                    "      \"user\":{\n" +
                    "        \"id\":\"5995d6a2-01b3-423c-a173-5481df49bdaf\",\n" +
                    "        \"provider\":\"OBP\",\n" +
                    "        \"display_name\":\"OBP\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
            transaction = mapper.readValue(jsonInString, Transaction.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transaction;
    }
}
