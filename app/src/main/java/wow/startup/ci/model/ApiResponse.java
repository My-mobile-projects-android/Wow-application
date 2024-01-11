package wow.startup.ci.model;

public class ApiResponse {
    private  String message;

    public ApiResponse(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
