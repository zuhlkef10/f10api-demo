package com.zuhlke.f10.transaction.service.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuhlke.f10.transaction.model.Transaction;
import com.zuhlke.f10.transaction.model.TransactionRequest;
import com.zuhlke.f10.transaction.model.TransactionResponse;
import com.zuhlke.f10.transaction.service.TransactionService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Profile("mock")
public class TransactionServiceMock implements TransactionService {

    public Transaction getTransactionById(String bankId, String accountId, String transactionId){

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
                    "    \"com.zuhlke.f10.bank\":{\n" +
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
                    "    \"com.zuhlke.f10.bank\":{\n" +
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


    public TransactionResponse createTransactionRequest(String bankId, String accountId,  TransactionRequest transactionRequest){

        String jsonString ="{\n" +
                "  \"id\":\"4050046c-63b3-4868-8a22-14b4181d33a6\",\n" +
                "  \"type\":\"SANDBOX_TAN\",\n" +
                "  \"from\":{\n" +
                "    \"bank_id\":\"gh.29.uk\",\n" +
                "    \"account_id\":\"8ca8a7e4-6d02-48e3-a029-0b2bf89de9f0\"\n" +
                "  },\n" +
                "  \"details\":{\n" +
                "    \"to_sandbox_tan\":{\n" +
                "      \"bank_id\":\"String\",\n" +
                "      \"account_id\":\"String\"\n" +
                "    },\n" +
                "    \"to_sepa\":{\n" +
                "      \"iban\":\"String\"\n" +
                "    },\n" +
                "    \"to_counterparty\":{\n" +
                "      \"counterparty_id\":\"String\"\n" +
                "    },\n" +
                "    \"to_transfer_to_phone\":{\n" +
                "      \"value\":{\n" +
                "        \"currency\":\"EUR\",\n" +
                "        \"amount\":\"10\"\n" +
                "      },\n" +
                "      \"description\":\"String\",\n" +
                "      \"message\":\"String\",\n" +
                "      \"from\":{\n" +
                "        \"mobile_phone_number\":\"String\",\n" +
                "        \"nickname\":\"String\"\n" +
                "      },\n" +
                "      \"to\":{\n" +
                "        \"mobile_phone_number\":\"String\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"to_transfer_to_atm\":{\n" +
                "      \"value\":{\n" +
                "        \"currency\":\"EUR\",\n" +
                "        \"amount\":\"10\"\n" +
                "      },\n" +
                "      \"description\":\"String\",\n" +
                "      \"message\":\"String\",\n" +
                "      \"from\":{\n" +
                "        \"mobile_phone_number\":\"String\",\n" +
                "        \"nickname\":\"String\"\n" +
                "      },\n" +
                "      \"to\":{\n" +
                "        \"legal_name\":\"String\",\n" +
                "        \"date_of_birth\":\"20181230\",\n" +
                "        \"mobile_phone_number\":\"String\",\n" +
                "        \"kyc_document\":{\n" +
                "          \"type\":\"String\",\n" +
                "          \"number\":\"String\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"to_transfer_to_account\":{\n" +
                "      \"value\":{\n" +
                "        \"currency\":\"EUR\",\n" +
                "        \"amount\":\"10\"\n" +
                "      },\n" +
                "      \"description\":\"String\",\n" +
                "      \"transfer_type\":\"String\",\n" +
                "      \"future_date\":\"20181230\",\n" +
                "      \"to\":{\n" +
                "        \"name\":\"String\",\n" +
                "        \"bank_code\":\"String\",\n" +
                "        \"branch_number\":\"String\",\n" +
                "        \"com.zuhlke.f10.account\":{\n" +
                "          \"number\":\"String\",\n" +
                "          \"iban\":\"String\"\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"value\":{\n" +
                "      \"currency\":\"EUR\",\n" +
                "      \"amount\":\"100\"\n" +
                "    },\n" +
                "    \"description\":\"String\"\n" +
                "  },\n" +
                "  \"transaction_ids\":[\"902ba3bb-dedd-45e7-9319-2fd3f2cd98a1\"],\n" +
                "  \"status\":\"COMPLETED\",\n" +
                "  \"start_date\":\"2013-01-22T00:08:00Z\",\n" +
                "  \"end_date\":\"2013-01-22T00:08:00Z\",\n" +
                "  \"challenge\":{\n" +
                "    \"id\":\"be1a183d-b301-4b83-b855-5eeffdd3526f\",\n" +
                "    \"allowed_attempts\":3,\n" +
                "    \"challenge_type\":\"SANDBOX_TAN\"\n" +
                "  },\n" +
                "  \"charge\":{\n" +
                "    \"summary\":\"Rent the flat\",\n" +
                "    \"value\":{\n" +
                "      \"currency\":\"EUR\",\n" +
                "      \"amount\":\"10\"\n" +
                "    }\n" +
                "  }\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        TransactionResponse response = null;
        try {
            response = mapper.readValue(jsonString, TransactionResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;

    }
}
