package hello.clients.support.response;

import hello.clients.support.error.ErrorMessage;

public class ClientResponse<S> {

    private final ResultType result;
    private final S data;
    private final ErrorMessage error;

    public ClientResponse(ResultType result, S data, ErrorMessage error) {
        this.result = result;
        this.data = data;
        this.error = error;
    }

    public static <S> ClientResponse<S> ok(S data) {
        return new ClientResponse<>(ResultType.SUCCESS, data, null);
    }

    public static <S> ClientResponse<S> failed(Exception e) {
        return new ClientResponse<>(ResultType.FAILURE, null, new ErrorMessage(e.getMessage()));
    }

    public ResultType getResult() {
        return result;
    }

    public S getData() {
        return data;
    }

    public ErrorMessage getError() {
        return error;
    }
}
