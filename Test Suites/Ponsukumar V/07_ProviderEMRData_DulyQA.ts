<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>07_ProviderEMRData_DulyQA</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>1</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>true</rerunImmediately>
   <testSuiteGuid>7a4ea187-ca5d-448b-aa28-d3ad8ab89cd0</testSuiteGuid>
   <testCaseLink>
      <guid>fe92444f-db97-49f9-b731-be802e90ec79</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/HII/07_ProviderEMRData/EMR01_ValidateProviderEMRDataUI</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>ccc4d1e1-1a96-422f-8098-d91be433099e</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/HII/07_ProviderEMRData/EMR02_ValidateProviderEMRDataGridUI</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>a9593457-f456-4427-be38-f5e8096fc9d2</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Dulyqa/07_ProviderEMRData/td_EMR02_ValidateProviderEMRDataGridUI</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>a9593457-f456-4427-be38-f5e8096fc9d2</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Region</value>
         <variableId>393a7c37-735d-4029-ad77-b47cad5e96e3</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>2f6eef28-3e20-4657-90a7-39c7f56b02d3</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/HII/07_ProviderEMRData/EMR24_ValidateFilterFunctionalitywithDifferentCombination</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>75991df0-3735-4657-9e5c-477649f59479</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Dulyqa/07_ProviderEMRData/td_EMR24_ValidateFilterFunctionalitywithDifferentCombination</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>75991df0-3735-4657-9e5c-477649f59479</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Region</value>
         <variableId>b86c276f-9769-496a-ac8f-f99f2ff6473a</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>75991df0-3735-4657-9e5c-477649f59479</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>CostCenter</value>
         <variableId>7487eab8-dc71-4df9-8199-4646a5607189</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>75991df0-3735-4657-9e5c-477649f59479</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Year</value>
         <variableId>be955680-2a41-4f19-a13a-b8006940a949</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>75991df0-3735-4657-9e5c-477649f59479</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Month</value>
         <variableId>61219640-c6ff-4ef2-b37f-232a75c2fa94</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>75991df0-3735-4657-9e5c-477649f59479</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>ProviderName</value>
         <variableId>46017d21-574c-42b8-9f8d-e8b927120e2c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>75991df0-3735-4657-9e5c-477649f59479</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>UniversalSearch</value>
         <variableId>7ce8f476-3456-4f2d-a107-0005057dcc0c</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>2ffd8bbc-4bb6-482f-b00a-a0c5064d94a7</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/HII/07_ProviderEMRData/EMR27_ValidateExportExceltoExportTheRecordsofOriginalAndProcessed</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>7bc9b647-6c03-4c9a-bd81-42dbe450f2b7</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/HII/07_ProviderEMRData/EMR29_ValidateDownloadFunctionalityofMissingType</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>436862ed-4d62-4a23-b866-9c259c818d7f</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Dulyqa/07_ProviderEMRData/td_EMR29_ValidateDownloadFunctionalityofMissingType</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>436862ed-4d62-4a23-b866-9c259c818d7f</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>MissingType</value>
         <variableId>bcb9f431-1745-45e9-ab1a-6b5a13637155</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>54a3a2d8-24e1-414d-9722-e92b4478ee2d</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/HII/07_ProviderEMRData/EMR30_ValidateScrollFunctionalityWhenEMRListContainsMax500records</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>66c5b3fa-47bf-4dc5-8b55-439a18860bcf</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Dulyqa/07_ProviderEMRData/td_EMR30_ValidateScrollFunctionalityWhenEMRListContainsMax500records</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>66c5b3fa-47bf-4dc5-8b55-439a18860bcf</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Region</value>
         <variableId>6a9c5cff-786c-4197-beaa-6b37fb1c1bfe</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>89dfe523-3c72-41df-9728-e3435d5ebb25</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/HII/07_ProviderEMRData/EMR31_ValidateNavigatePagination</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>6f8533fe-0435-4ccc-a046-e7e9279303ad</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Dulyqa/07_ProviderEMRData/td_EMR31_ValidateNavigatePagination</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>6f8533fe-0435-4ccc-a046-e7e9279303ad</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Region</value>
         <variableId>3cf37f87-2d0b-4c51-9679-b8e621e20d64</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>874ffdac-4aa8-48e7-b58c-51d8174745ad</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/HII/07_ProviderEMRData/EMR33_ValidateDetailsLinkshowsthewRVUSofProvider</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>10156d06-f8e9-4f22-8956-a41fd6c9c7ee</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Dulyqa/07_ProviderEMRData/td_EMR33_ValidateDetailsLinkshowsthewRVUSofProvider</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>10156d06-f8e9-4f22-8956-a41fd6c9c7ee</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Region</value>
         <variableId>dc9c2801-f558-44fd-9272-cdb85f8d0ffd</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>3e006c2c-b026-416b-b26e-80159308e444</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/HII/07_ProviderEMRData/EMR34_ValidateUploadEMRFileTypeAsPerApplicableFlagSettings</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>6ec95f54-601f-4f97-9923-bbcaf7b61700</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Dulyqa/07_ProviderEMRData/td_EMR34_ValidateUploadEMRFileTypeAsPerApplicableFlagSettings</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>6ec95f54-601f-4f97-9923-bbcaf7b61700</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Region</value>
         <variableId>cba8ad08-4320-4b19-90fc-6c8fad918899</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>6ec95f54-601f-4f97-9923-bbcaf7b61700</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Location</value>
         <variableId>7bb61584-b5e0-4f23-8634-53e0b1421483</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>152de525-897f-4905-8269-16d3798c1b45</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/HII/07_ProviderEMRData/EMR35_Validate DisplayOriginalEMRDataAsPerApplicableSettings</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>e7672a8a-5522-4967-935c-45be60ff0713</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Dulyqa/07_ProviderEMRData/td_EMR34_ValidateUploadEMRFileTypeAsPerApplicableFlagSettings</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>e7672a8a-5522-4967-935c-45be60ff0713</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Region</value>
         <variableId>366af01d-aa88-45aa-a776-ca4bf6b0ab4e</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>e7672a8a-5522-4967-935c-45be60ff0713</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Location</value>
         <variableId>26f896e2-fa75-4f09-871e-5c712bbc5060</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>