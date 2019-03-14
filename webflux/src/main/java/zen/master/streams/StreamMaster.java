package zen.master.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.json.JSONException;
import org.json.JSONObject;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

public class StreamMaster {

    private JList jList1;
    private JPanel jPanel1;
    private JButton refreshButton;

    public StreamMaster() {
        initComponents();
    }

    private void initComponents() {
        JFrame f = new JFrame();
        jPanel1 = new JPanel();
        jList1 = new JList();
        refreshButton = new JButton();

        refreshButton.setText("Refresh alle");
        refreshButton.addActionListener(actionEvent -> {
            //TODO load new names
        });

        jList1.setModel(new AbstractListModel() {

            String[] strings = {"Item 1", "Item 2", "Item 3"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        jList1.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });

        jPanel1.add(jList1);
        jPanel1.add(refreshButton);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(jPanel1);
        f.pack();
        f.setVisible(true);
    }

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        String s = (String) jList1.getSelectedValue();
        if (s.equals("Item 1")) {
        }
        if (s.equals("Item 2")) {

        }
        if (s.equals("Item 3")) {

        }
    }

    public static void main(String args[]) throws IOException, JSONException {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new StreamMaster();
            }
        });

        String url = "https://uinames.com/api/?ext";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
        System.out.println(response.toString());
        //Read JSON response and print
        JSONObject myResponse = new JSONObject(response.toString());


        /**
         * Create publisher
         */
        FluxProcessor publisher = DirectProcessor.create().serialize();
        FluxSink sink = publisher.sink();
    }
}