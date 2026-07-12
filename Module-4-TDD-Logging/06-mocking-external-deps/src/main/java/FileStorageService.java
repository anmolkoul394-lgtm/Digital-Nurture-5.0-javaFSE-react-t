// FileStorageService.java
// Represents an EXTERNAL dependency - a real implementation would read/write files
// on disk (or cloud storage). We depend on this INTERFACE so tests never touch a real file.

public interface FileStorageService {
    void saveReceipt(String orderId, String content);
}
