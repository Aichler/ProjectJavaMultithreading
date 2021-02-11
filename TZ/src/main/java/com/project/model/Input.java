package com.project.model;

import java.util.HashSet;

public class Input {
    private HashSet<String> id;
    private HashSet<String> version;
    private HashSet<String> path;

    public Input() {
    }

    public HashSet<String> getId() {
        return id;
    }

    public void setId(HashSet<String> id) {
        this.id = id;
    }

    public HashSet<String> getVersion() {
        return version;
    }

    public void setVersion(HashSet<String> version) {
        this.version = version;
    }

    public HashSet<String> getPath() {
        return path;
    }

    public void setPath(HashSet<String> path) {
        this.path = path;
    }
}
