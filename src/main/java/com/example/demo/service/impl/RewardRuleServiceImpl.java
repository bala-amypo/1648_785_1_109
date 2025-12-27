@Service
public class RewardRuleServiceImpl implements RewardRuleService {
    private final RewardRuleRepository repo;
    public RewardRuleServiceImpl(RewardRuleRepository repo) { this.repo = repo; }

    @Override
    public RewardRule createRule(RewardRule rule) { return repo.save(rule); }

    @Override
    public List<RewardRule> getActiveRules() { return repo.findByActiveTrue(); }

    @Override
    public List<RewardRule> getAllRules() { return repo.findAll(); }
}