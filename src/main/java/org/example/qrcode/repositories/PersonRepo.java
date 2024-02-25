package org.example.qrcode.repositories;

import org.example.qrcode.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
