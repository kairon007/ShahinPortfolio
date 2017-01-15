package com.shahinjo.thingy.shahinportfolio.Managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by shahin on 1/14/17.
 */

public class SOAPConnectionManager {

    private static SoapObject soapRequest;
    private static SoapSerializationEnvelope soapEnvelope;
    private static HttpTransportSE androidHttpTransport;
    private static SoapPrimitive soapResult;

    private static SharedPreferences settings;

    /**
     * Checking the availability of network connection
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager contextManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = contextManager.getActiveNetworkInfo();

            return networkInfo != null;

        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Get Server URL From Shared Preferences to consume the WCF Service
     *
     * @param context
     * @return
     */
    public static String getConnectionURL(Context context) {
        settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferencesManager.setSharedPreferences(settings);

        String sURL = "";

        /*if (SharedPreferencesManager.getSettingsWCFDirectory().trim().equals("")) {
            sURL = "http://" + SharedPreferencesManager.getSettingsServerIP() + "/" + SharedPreferencesManager.getSettingsServiceName();
        } else {
            sURL = "http://" + SharedPreferencesManager.getSettingsServerIP() + "/" + SharedPreferencesManager.getSettingsWCFDirectory() + "/" + SharedPrefsManager.getSettingsServiceName();
        }*/

        return sURL;
    }

    /**
     * Initializing the Soap Object and Prepare it for Requests ahead
     *
     * @param actionName
     * @param context
     */
    public static void setupSOAPConnection(String actionName, Context context) {

        String URL = getConnectionURL(context);

        soapRequest = new SoapObject(ConstantsManager.SOAP_NAMESPACE, actionName);

        soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.dotNet = true;
        soapEnvelope.implicitTypes = true;
        soapEnvelope.setAddAdornments(false);
        soapEnvelope.encodingStyle = "utf-8";

        androidHttpTransport = new HttpTransportSE(URL);
        androidHttpTransport.debug = true;

    }

    /**
     * Attach SOAP Properties
     * Properties are the parameters of SOAP interfaces
     * <p>
     * Note : Properties must be added in the same order as the Interface Contract, Sequence is important
     *
     * @param propertyKey
     * @param value
     */
    public static void attachSOAPProperty(String propertyKey, Object value) {
        Log.w("ATTACH_PROPERTY", propertyKey + " - " + value);
        soapRequest.addProperty(propertyKey, value);

    }

    /**
     * Execute SOAP Request by calling action from server
     *
     * @param actionName
     * @throws XmlPullParserException
     * @throws IOException
     */
    public static void executeSOAPRequest(String actionName) throws XmlPullParserException, IOException {

        soapEnvelope.setOutputSoapObject(soapRequest);
        androidHttpTransport.call((ConstantsManager.SOAP_ACTION_ROOT + actionName), soapEnvelope);


    }

    /**
     * Get the SOAR Response to retrieve data from server
     *
     * @return
     * @throws SoapFault
     */
    public static String getSOAPResponse() throws SoapFault {
        soapResult = (SoapPrimitive) soapEnvelope.getResponse();
        return soapResult.toString();
    }

}
