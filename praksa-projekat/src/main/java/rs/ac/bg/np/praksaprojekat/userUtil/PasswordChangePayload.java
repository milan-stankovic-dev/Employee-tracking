package rs.ac.bg.np.praksaprojekat.userUtil;

public record PasswordChangePayload(
        String email,
        String oldPassword,
        String newPassword
)
{ }
