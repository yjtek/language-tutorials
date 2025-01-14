package subdir

func SGConfigs() (configs map[string]interface{}) {
	sgConfigs := make(map[string]interface{})
	sgConfigs["logTag"] = "atom-p2m-handler"
	sgConfigs["budgetMultiplier"] = 1.0
	sgConfigs["grandPrizeTotalEligibleTxns"] = 1300000 * 2 // 2mths of txns (~60% of 2m txns = 1.2m to exclude nets txns, plus a little more to exhaust grand prize awarding)
	sgConfigs["grandPrizeInventory"] = 213                 // inventory for 2 mths
	sgConfigs["netsMultiplier"] = 1.0
	sgConfigs["rewardPolicyRaw"] = []float64{
		0, 0, 0, 1,
		0, 0, 1, 1,
		0, 1, 1, 2,
		1, 1, 2, 2,
	}
	sgConfigs["rewardProbDistRaw"] = []float64{
		0.05, 0.05, 0.075,
		0.05, 0.075, 0.75,
		0.075, 0.75, 0.075,
		0.75, 0.075, 0.05,
		0.075, 0.05, 0.05,
	}
	sgConfigs["rewardMultiplierDistRaw"] = []float64{
		1.0, 1.4, 1.8, 3.0,
		0.7, 1.0, 1.4, 1.8,
		0.3, 0.7, 1.0, 1.4,
		0.0, 0.3, 0.7, 1.0,
		0.0, 0.0, 0.3, 0.7,
	}
	return sgConfigs
}

func GetP2MConfigs(countryCode string) (rewardPolicyRaw []float64) {

	switch countryCode {
	case "sg":
		configs := SGConfigs()
		rewardPolicyRaw := configs["rewardPolicyRaw"].([]float64)
		//rewardProbDistRaw := configs["rewardProbDistRaw"].([]float64)
		//rewardMultiplierDistRaw := configs["rewardMultiplierDistRaw"].([]float64)
		// budgetMultiplier := configs["budgetMultiplier"].(float64)
		// grandPrizeTotalEligibleTxns := configs["grandPrizeTotalEligibleTxns"].(int)
		// grandPrizeInventory := configs["grandPrizeTotalEligibleTxns"].(int)
		return rewardPolicyRaw
	default:
		panic("Country code not specified")
		// rewardPolicyRaw := []float64{0.0}
		// return rewardPolicyRaw
	}

	// allConfigs := make(map[string]map[string]interface{})
	// allConfigs["sg"] = makeSGConfigs()

	// return allConfigs[countryCode]
}

// func GetConfigs(countryName string) (configs map[string]map[string]interface{}) {
// 	nestedMap := make(map[string]map[string]interface{})

// 	innerMap1 := make(map[string]interface{})
// 	innerMap1["field1"] = "value1"
// 	innerMap1["field2"] = 42

// 	innerMap2 := make(map[string]interface{})
// 	innerMap2["field1"] = "value2"
// 	innerMap2["field2"] = true

// 	nestedMap["key1"] = innerMap1
// 	nestedMap["key2"] = innerMap2

// 	return nestedMap
// }
