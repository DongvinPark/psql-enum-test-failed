package com.example.psqlenumtest;

import com.example.psqlenumtest.common.TransmissionStatusType;
import com.example.psqlenumtest.persist.EnrollmentCycleTransmission;
import com.example.psqlenumtest.persist.EnrollmentCycleTransmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final EnrollmentCycleTransmissionRepository ectRepository;

    @GetMapping("/test")
    public void test() {

        EnrollmentCycleTransmission entity = new EnrollmentCycleTransmission();
        entity.setApprovalID(1L);
        entity.setTransmitterID(2L);
        entity.setTransmissionStatus(TransmissionStatusType.accepted);
        entity.setTransmissionDate(LocalDateTime.now());
        entity.setTPAApprovalID("test approval");
        entity.setTPAStatusCode("test TPA Code");
        entity.setTPAStatusMessage("test message");

        ectRepository.save(entity);

    }

}
