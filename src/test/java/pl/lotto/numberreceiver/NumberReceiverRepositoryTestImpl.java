package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

public class NumberReceiverRepositoryTestImpl implements NumberReceiverRepository {

    Map<String, LotteryTicket> database = new ConcurrentHashMap<>();

    @Override
    public LotteryTicket save(LotteryTicket lotteryTicket) {
        return database.put(lotteryTicket.getLotteryId(), lotteryTicket);
    }

    @Override
    public List<LotteryTicket> findAllByDrawDate(LocalDateTime nextDrawDate) {
        return database.values()
                .stream()
                .filter(e -> e.getDrawDate().equals(nextDrawDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<LotteryTicket> findAll() {
        return database.values().stream().toList();
    }

    @Override
    public <S extends LotteryTicket> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<LotteryTicket> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<LotteryTicket> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(LotteryTicket entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends LotteryTicket> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<LotteryTicket> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<LotteryTicket> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends LotteryTicket> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends LotteryTicket> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends LotteryTicket> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends LotteryTicket> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends LotteryTicket> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends LotteryTicket> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends LotteryTicket> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends LotteryTicket> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends LotteryTicket, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
