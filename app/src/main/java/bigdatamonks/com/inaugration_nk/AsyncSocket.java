package bigdatamonks.com.inaugration_nk;

import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import android.content.Context;
import android.os.AsyncTask;


public class AsyncSocket extends AsyncTask<String, Void , Void>  {

    private Context c;
    private String address = null;
    private int port=0;
    private Exception exception;
    private Socket client = null;

    public AsyncSocket(Context con,String ip, int portnum)
    {

        c = con;
        address = ip;
        port = portnum;
    }



        protected Void doInBackground(String... IP) {






               // Toast.makeText(c, "Before Connection "  , Toast.LENGTH_SHORT).show();
                client =  new Socket();
                try {
                    client.connect(new InetSocketAddress(address, port));







               // Toast.makeText(c, "Hey Connected" , Toast.LENGTH_SHORT).show();

                final OutputStream outToServer = this.client.getOutputStream();
                final DataOutputStream out = new DataOutputStream(outToServer);
                out.writeUTF("Start");
                out.flush();
                out.close();

               // Toast.makeText(c, "Done" , Toast.LENGTH_SHORT).show();

                } catch (Exception e){e.printStackTrace();}


            return null;
        }

        protected void onPostExecute( ) {
            // TODO: check this.exception
            // TODO: do something with the feed
        }
    }


