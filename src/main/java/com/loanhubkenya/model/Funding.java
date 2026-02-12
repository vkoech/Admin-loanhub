package com.loanhubkenya.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funding {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String category;
    private String type;
    private String eligibility;
    private String link;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    private boolean active = true;
}
