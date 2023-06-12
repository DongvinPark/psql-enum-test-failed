package com.example.psqlenumtest.persist;

import com.example.psqlenumtest.common.TransmissionStatusType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Access(javax.persistence.AccessType.PROPERTY)
@Table(name="transmissions")
public class EnrollmentCycleTransmission {

    // elements of enum status column
    /*private static final String ACCEPTED_TRANSMISSION = "accepted";
    private static final String REJECTED_TRANSMISSION = "rejected";
    private static final String DUPLICATE_TRANSMISSION = "duplicate";
    private static final String EXCEPTION_TRANSMISSION = "exception";
    private static final String RETRY_TRANSMISSION = "retry";*/

    private Long transmissionID;
    private Long approvalID;
    private Long transmitterID;

    private TransmissionStatusType transmissionStatus;

    private LocalDateTime transmissionDate;
    private String TPAApprovalID;
    private String TPAStatusCode;
    private String TPAStatusMessage;


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getTransmissionID() {
        return transmissionID;
    }

    public void setTransmissionID(Long transmissionID) {
        this.transmissionID = transmissionID;
    }

    @Column(name = "approval_id")
    public Long getApprovalID() {
        return approvalID;
    }

    public void setApprovalID(Long approvalID) {
        this.approvalID = approvalID;
    }

    @Column(name = "transmitter")
    public Long getTransmitterID() {
        return transmitterID;
    }

    public void setTransmitterID(Long transmitterID) {
        this.transmitterID = transmitterID;
    }

    @Column(name = "status")
    @Type(type = "com.example.psqlenumtest.persist.PGEnumUserType" , parameters ={@org.hibernate.annotations.Parameter(name = "TransmissionStatusType",value = "com.example.psqlenumtest.common.TransmissionStatusType")} )
    public TransmissionStatusType getTransmissionStatus() {
        return this.transmissionStatus ;
    }

    public void setTransmissionStatus(TransmissionStatusType transmissionStatus) {
        this.transmissionStatus = transmissionStatus;
    }

    @Column(name = "transmission_date")
    public LocalDateTime getTransmissionDate() {
        return transmissionDate;
    }

    public void setTransmissionDate(LocalDateTime transmissionDate) {
        this.transmissionDate = transmissionDate;
    }

    @Column(name = "tpa_approval_id")
    public String getTPAApprovalID() {
        return TPAApprovalID;
    }

    public void setTPAApprovalID(String TPAApprovalID) {
        this.TPAApprovalID = TPAApprovalID;
    }

    @Column(name = "tpa_status_code")
    public String getTPAStatusCode() {
        return TPAStatusCode;
    }

    public void setTPAStatusCode(String TPAStatusCode) {
        this.TPAStatusCode = TPAStatusCode;
    }

    @Column(name = "status_message")
    public String getTPAStatusMessage() {
        return TPAStatusMessage;
    }

    public void setTPAStatusMessage(String TPAStatusMessage) {
        this.TPAStatusMessage = TPAStatusMessage;
    }
}
