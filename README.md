# Android BOOT_COMPLETED handler

This module add support to run JS file when Android device has completed booting (received BOOT_COMPLETED broadcast intent)

Create `boot_completed.js` inside Resources folder, and this file will be called when it receives BOOT_COMPLETED intent.

You may also change the filename by editing `<android>` tag inside `tiapp.xml`, modifying meta data `boot_completed_js` value:

    <android>
        <manifest>
            <application>
                <receiver android:name="nc.bootcompleted.BootCompletedReceiver">
                    <meta-data android:name="boot_completed_js" android:value="lib/boot_completed_handler.js"/>
                    <!-- Resources/lib/boot_completed_handler.js will be called instead -->
                </receiver>
            </application>
        </manifest>
    </android>
    
