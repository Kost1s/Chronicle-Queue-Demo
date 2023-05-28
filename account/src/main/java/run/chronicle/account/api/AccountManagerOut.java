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

/**
 * The package that contains the API interfaces for the account management system.
 */
package run.chronicle.account.api;

// Import relevant class
import run.chronicle.account.dto.CheckPoint;

/**
 * This interface extends both the CreateAccountOut and TransferOut interfaces.
 * It provides methods to manage account operations including account creation,
 * transfers, and checkpoint handling.
 */
public interface AccountManagerOut extends CreateAccountOut, TransferOut {

    /**
     * This method initiates a checkpoint operation. It takes a CheckPoint object
     * as a parameter, which contains the details of the checkpoint to be started.
     *
     * @param checkPoint a CheckPoint object encapsulating the details of the
     *                   checkpoint to be started.
     */
    void startCheckpoint(CheckPoint checkPoint);

    /**
     * This method concludes a checkpoint operation. It takes a CheckPoint object
     * as a parameter, which contains the details of the checkpoint to be ended.
     *
     * @param checkPoint a CheckPoint object encapsulating the details of the
     *                   checkpoint to be ended.
     */
    void endCheckpoint(CheckPoint checkPoint);
}
