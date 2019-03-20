package service;

import mapper.DemoTwoMapper;
import model.Demo;

import java.util.List;

public class DemoTwoService {
    private DemoTwoMapper demoMapper = new DemoTwoMapper();
    public List<Demo> getDemoList() {
        return demoMapper.getDemoList();
    }
}
