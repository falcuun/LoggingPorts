/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portlogging2;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author falcu
 */
public class PortGetting {

    private String stat;

    public void setStat(String stat) {
        this.stat = stat;
    }

    public static class Protocoll {

        public String protocoll;
        public String localAddress;
        public String remoteAddress;
        public String status;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        public Protocoll(String protocoll, String localAddress, String remoteAddress, String status) {
            this.protocoll = protocoll;
            this.localAddress = localAddress;
            this.remoteAddress = remoteAddress;
            this.status = status;
        }

        @Override
        public String toString() {
            return String.format("%-22s %-22s %-22s %-22s %s", dtf.format(now),protocoll, localAddress, remoteAddress, status);
        }
    }

    public static Iterable<Protocoll> netStat() throws IOException {
        Collection<Protocoll> result = new ArrayList<>();
        ProcessBuilder builder = new ProcessBuilder("netstat", "-q");
        Process p = builder.start();
        try (Scanner scanner = new Scanner(p.getInputStream())) {
            Pattern pattern = Pattern.compile("(TCP|UDP)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)");
            while (scanner.findWithinHorizon(pattern, 0) != null) {
                result.add(new Protocoll(scanner.match().group(1), scanner.match().group(2), scanner.match().group(3), scanner.match().group(4)));
            }
        }
        return result;
    }

    public void findPorts() throws Exception {
        for (Protocoll p : netStat()) {
            if (p.status.equals(stat)) {
                System.out.println(p);
            }
        }
    }
}
