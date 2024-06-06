package com.globtechpower.globtpfapidata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globtechpower.globtpfapidata.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}
