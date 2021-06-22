package hello;

public class EchoEnitity {
    private final String method;
    private final String requestURI;
    private final String protocol;
    private final String pathInfo;
    private final String remoteAddr;


    public EchoEnitity(String method, String requestURI, String protocol, String pathInfo, String remoteAddr) {
        this.method = method;
        this.requestURI = requestURI;
        this.protocol = protocol;
        this.pathInfo = pathInfo;
        this.remoteAddr = remoteAddr;
    }

    public String getMethod() {
        return method;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getPathInfo() {
        return pathInfo;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }
}
