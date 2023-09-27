package lesson24;

// http://colormind.io/list
// ipv4 0.0.0.0-255.255.255.255
// ipv6
// dns www.whitehouse.gov -> 192.0.66.168
// 80/tcp -> http
// 25/tcp -> smtp
// 53/udp -> dns

import java.io.*;
import java.net.Socket;

public class A_Socket {
    public static void main(String[] args) {
        String server = "colormind.io";
        int port = 80;
        String service = "/list";
        try(
                Socket socket = new Socket(server, port);
                InputStream is = socket.getInputStream();// читать
                OutputStream os = socket.getOutputStream(); // писать
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                OutputStreamWriter osw = new OutputStreamWriter(os);
        )
        {
            osw.write("GET http://colormind.io/list/ HTTP/1.0\n\n");
            osw.flush(); // не кэшировать, а сбростиь данные сразу в поток
            br.lines().forEach(System.out::println);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

    }
}
