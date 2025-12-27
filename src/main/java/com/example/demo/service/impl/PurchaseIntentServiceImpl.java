@Service
public class PurchaseIntentServiceImpl implements PurchaseIntentService {
    private final PurchaseIntentRecordRepository repo;
    public PurchaseIntentServiceImpl(PurchaseIntentRecordRepository repo) { this.repo = repo; }

    @Override
    public PurchaseIntentRecord createIntent(PurchaseIntentRecord intent) { return repo.save(intent); }

    @Override
    public List<PurchaseIntentRecord> getIntentsByUser(Long userId) { return repo.findByUserId(userId); }

    @Override
    public List<PurchaseIntentRecord> getAllIntents() { return repo.findAll(); }
}