package org.twilio.smsmarketing.lib;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class Sender {

    private final TwilioRestClient client;

    public Sender() {
        client = new TwilioRestClient(Config.getAccountSid(), Config.getAuthToken());
    }

    public Sender(TwilioRestClient client) {
        this.client = client;
    }

    public void send(String to, String message, String imageUri) {
        List<NameValuePair> params = buildParams(to, message, imageUri);

        try {
            client.getAccount().getMessageFactory().create(params);
        } catch (TwilioRestException exception) {
            exception.printStackTrace();
        }
    }

    private List<NameValuePair> buildParams(String to, String message, String imageUri) {
        List<NameValuePair> params = new ArrayList<>();

        params.add(new BasicNameValuePair("To", to));
        params.add(new BasicNameValuePair("From", Config.getPhoneNumber()));
        params.add(new BasicNameValuePair("Body", message));
        params.add(new BasicNameValuePair("MediaUrl", imageUri));

        return params;
    }
}