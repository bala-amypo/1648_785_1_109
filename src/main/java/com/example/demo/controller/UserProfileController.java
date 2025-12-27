@RestController
@RequestMapping("/api/users")
public class UserProfileController {
    private final UserProfileService userService;
    public UserProfileController(UserProfileService userService) { this.userService = userService; }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}