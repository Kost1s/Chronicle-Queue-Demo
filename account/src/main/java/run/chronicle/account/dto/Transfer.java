/*
 * Copyright 2016-2022 chronicle.software
 *
 *       https://chronicle.software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package run.chronicle.account.dto;

import net.openhft.chronicle.bytes.Bytes;
import net.openhft.chronicle.core.io.InvalidMarshallableException;
import net.openhft.chronicle.wire.converter.Base85;
/**
 * The Transfer class extends AbstractEvent and represents a transfer event in the banking system.
 * It encapsulates all necessary details of a transfer, including the account numbers of both sender and receiver, the currency, the amount, and a reference to the transaction details. Like the previous classes,
 * it also provides a fluent interface for setters and includes a validate method to ensure all required fields are set.
 */
public class Transfer extends AbstractEvent<Transfer> {
    private long from, to; // The account numbers for the transfer
    @Base85
    private int currency; // The currency of the transfer, represented in Base85 format
    private double amount; // The amount to be transferred
    private Bytes reference = Bytes.allocateElasticOnHeap(); // Reference to the transaction details

    /**
     * Returns the sender's account number.
     *
     * @return the sender's account number
     */
    public long from() {
        return from;
    }

    /**
     * Sets the sender's account number and returns the updated object.
     *
     * @param from the sender's account number
     * @return the updated object
     */
    public Transfer from(long from) {
        this.from = from;
        return this;
    }

    /**
     * Returns the receiver's account number.
     *
     * @return the receiver's account number
     */
    public long to() {
        return to;
    }

    /**
     * Sets the receiver's account number and returns the updated object.
     *
     * @param to the receiver's account number
     * @return the updated object
     */
    public Transfer to(long to) {
        this.to = to;
        return this;
    }

    /**
     * Returns the currency of the transfer.
     *
     * @return the currency of the transfer
     */
    public int currency() {
        return currency;
    }

    /**
     * Sets the currency of the transfer and returns the updated object.
     *
     * @param currency the currency of the transfer
     * @return the updated object
     */
    public Transfer currency(int currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Returns the amount to be transferred.
     *
     * @return the amount to be transferred
     */
    public double amount() {
        return amount;
    }

    /**
     * Sets the amount to be transferred and returns the updated object.
     *
     * @param amount the amount to be transferred
     * @return the updated object
     */
    public Transfer amount(double amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Sets the reference to the transaction details and returns the updated object.
     *
     * @param reference the reference to the transaction details
     * @return the updated object
     */
    public Transfer reference(Bytes reference) {
        this.reference.clear().append(reference);
        return this;
    }

    /**
     * The validate method is used to verify that all necessary properties have been set.
     *
     * @throws InvalidMarshallableException If any of these properties is not set
     */
    @Override
    public void validate() throws InvalidMarshallableException {
        super.validate(); // Validate fields in the parent class
        if (from == 0)
            throw new InvalidMarshallableException("from must be set"); // Ensure 'from' is set
        if (to == 0)
            throw new InvalidMarshallableException("to must be set"); // Ensure 'to' is set
        if (currency == 0)
            throw new InvalidMarshallableException("currency must be set"); // Ensure 'currency' is set
        if (amount == 0)
            throw new InvalidMarshallableException("amount must be set"); // Ensure 'amount' is set
        if (reference == null)
            throw new InvalidMarshallableException("reference must be set"); // Ensure 'reference' is set
    }

    /**
     * Overridden to specify the message format. In this case, it uses a lower level binary format,
     * not a self-describing message.
     *
     * @return false as it does not use a self-describing message.
     */
    @Override
    public boolean usesSelfDescribingMessage() {
        return false;
    }
}
