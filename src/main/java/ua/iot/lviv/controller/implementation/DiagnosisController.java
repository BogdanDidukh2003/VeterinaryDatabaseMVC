package ua.iot.lviv.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.lviv.domain.implementation.DiagnosisEntity;
import ua.iot.lviv.service.Service;
import ua.iot.lviv.service.implementation.DiagnosisService;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController extends ControllerImp<DiagnosisEntity> {
    @Autowired
    DiagnosisService diagnosisService;

    @Override
    public Service<DiagnosisEntity> getService() {
        return diagnosisService;
    }
}
