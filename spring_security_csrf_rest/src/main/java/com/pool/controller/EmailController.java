package com.pool.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pool.model.Email;
import com.pool.model.SendEmailRequest;
import com.pool.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public void sendEmail(@RequestBody SendEmailRequest request, Authentication authentication) {
        this.emailService.send(authentication.getName(), request);
    }

    @GetMapping
    public List<Email> findAll(Authentication authentication) {
        return this.emailService.findAll(authentication.getName());
    }

    @GetMapping("/{id}")
    // @PostAuthorize("returnObject?.body?.to() == principal?.username")
    public ResponseEntity<Email> findById(@PathVariable Long id) {
        Optional<Email> email = this.emailService.findById(id);
        return ResponseEntity.of(email);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.emailService.delete(id);
    }

    @PostMapping(value = "/send", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void sendEmailForm(SendEmailRequest request) {
        this.emailService.send("marcus@example.com", request);
    }
}
