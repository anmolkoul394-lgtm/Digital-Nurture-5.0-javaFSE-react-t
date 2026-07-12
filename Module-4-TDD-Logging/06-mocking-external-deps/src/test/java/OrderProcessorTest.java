// OrderProcessorTest.java
// Demonstrates mocking TWO external dependencies (a payment API and file storage)
// so OrderProcessor can be tested completely in isolation - no real network or disk I/O.

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderProcessorTest {

    @Mock
    private PaymentGatewayClient paymentGatewayClient; // mocked EXTERNAL payment API

    @Mock
    private FileStorageService fileStorageService;     // mocked EXTERNAL file I/O

    @Test
    void testProcessOrder_paymentSucceeds_savesReceipt() {
        OrderProcessor processor = new OrderProcessor(paymentGatewayClient, fileStorageService);

        // Stub the external payment API to simulate a SUCCESSFUL charge
        when(paymentGatewayClient.charge("4111111111111111", 999.0)).thenReturn(true);

        boolean result = processor.processOrder("ORD-1", "4111111111111111", 999.0);

        assertTrue(result);
        // Verify the external file storage was called exactly once, with the right content
        verify(fileStorageService, times(1))
                .saveReceipt("ORD-1", "Order ORD-1: charged $999.0");
    }

    @Test
    void testProcessOrder_paymentFails_doesNotSaveReceipt() {
        OrderProcessor processor = new OrderProcessor(paymentGatewayClient, fileStorageService);

        // Stub the external payment API to simulate a FAILED charge
        when(paymentGatewayClient.charge("0000000000000000", 500.0)).thenReturn(false);

        boolean result = processor.processOrder("ORD-2", "0000000000000000", 500.0);

        assertFalse(result);
        // Verify saveReceipt was NEVER called, since payment failed
        verify(fileStorageService, never()).saveReceipt("ORD-2", "Order ORD-2: charged $500.0");
    }

    @Test
    void testProcessOrder_multipleCalls() {
        OrderProcessor processor = new OrderProcessor(paymentGatewayClient, fileStorageService);
        when(paymentGatewayClient.charge("1234", 100.0)).thenReturn(true);

        processor.processOrder("ORD-3", "1234", 100.0);
        processor.processOrder("ORD-3", "1234", 100.0);

        // Verify the mock's charge() method was called exactly twice
        verify(paymentGatewayClient, times(2)).charge("1234", 100.0);
    }
}
