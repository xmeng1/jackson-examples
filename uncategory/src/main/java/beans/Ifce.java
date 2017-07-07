package beans;

public class Ifce {
    private String port;
    private String reservableBW;
    private String[] capabilites;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getReservableBW() {
        return reservableBW;
    }

    public void setReservableBW(String reservableBW) {
        this.reservableBW = reservableBW;
    }

    public String[] getCapabilites() {
        return capabilites;
    }

    public void setCapabilites(String[] capabilites) {
        this.capabilites = capabilites;
    }
}
