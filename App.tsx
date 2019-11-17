import React, { Fragment } from 'react';
import {
  SafeAreaView,
  StyleSheet,
  Text,
  View,
  NativeModules,
  TouchableOpacity
} from 'react-native';

const onClickWelcomeButton = () => {
  NativeModules.ExpensesModule.show()
}

const App = () => {

  return (
    <Fragment>
      <SafeAreaView style={styles.container}>
        <TouchableOpacity onPress={onClickWelcomeButton}>
          <View style={styles.buttonView}>
            <Text style={styles.buttonTextContent}>
              Welcome to Pleo
            </Text>
          </View>
        </TouchableOpacity>
      </SafeAreaView>
    </Fragment>
  )
}

const styles = StyleSheet.create({
  container: {
    display: "flex",
    flexDirection: 'row',
    alignItems: 'center',
    flex: 1,
    marginTop: 10,
    paddingTop: 10,
    paddingBottom: 10,
    justifyContent: "center"
  },
  buttonView: {
    borderRadius: 25,
    backgroundColor: "#FF3366",
    paddingTop: 8,
    paddingBottom: 8,
    paddingEnd: 16,
    paddingStart: 16,
    alignSelf: "center"
  },
  buttonTextContent: {
    color: "#FFFFFF",
    fontSize: 18
  }
});

export default App