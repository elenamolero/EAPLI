/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.candidatemanagement.repositories.CandidateRepository;
import eapli.base.candidatemanagement.repositories.CustomerRepository;
import eapli.base.candidatemanagement.repositories.SignupRequestRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.interviewmanagement.repository.InterviewApplicationRepository;
import eapli.base.jobapplicationmanagement.repository.JobApplicationRepository;
import eapli.base.jobapplicationmanagement.repository.RankingRepository;
import eapli.base.jobopeningmanagement.repositories.JobOpeningRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public InterviewApplicationRepository interviewApplications(final TransactionalContext tx) {
        return new InMemoryInterviewApplicationRepository();
    }
    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public CandidateRepository candidates(final TransactionalContext tx) {

        return new InMemoryCandidateRepository();
    }
    @Override
    public RankingRepository rankings(final TransactionalContext tx) {

        return new InMemoryRankingRepository();
    }

    @Override
    public CustomerRepository customers(final TransactionalContext tx) {

        return new InMemoryCustomerRepository();
    }

    @Override
    public JobOpeningRepository jobOpenings(final TransactionalContext tx) {

        return new InMemoryJobOpeningRepository();
    }
    @Override
    public JobApplicationRepository jobApplications(final TransactionalContext tx) {

        return new InMemoryJobApplicationRepository();
    }

    @Override
    public CandidateRepository candidates() {
        return candidates(null);
    }

    @Override
    public RankingRepository rankings() {
        return rankings(null);
    }

    @Override
    public JobOpeningRepository jobOpenings() {
        return jobOpenings(null);
    }
    @Override
    public JobApplicationRepository jobApplications() {
        return jobApplications(null);
    }
    @Override
    public InterviewApplicationRepository interviewApplications() {
        return interviewApplications(null);
    }
    @Override
    public CustomerRepository customers() {
        return customers(null);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

}
