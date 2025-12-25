public interface CreditCardRecordRepository extends JpaRepository<CreditCardRecord, Long> {
    List<CreditCardRecord> findByUserId(Long userId);
    List<CreditCardRecord> findActiveCardsByUser(Long userId);
}
