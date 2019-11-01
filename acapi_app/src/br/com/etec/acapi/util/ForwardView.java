package br.com.etec.acapi.util;

public class ForwardView {

    private String viewName;

    public ForwardView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public String toString() {
        return viewName;
    }

}