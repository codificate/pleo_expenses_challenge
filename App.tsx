import React, { Fragment } from 'react';
import {
  SafeAreaView,
  StyleSheet,
  Text,
  Alert,
  View,
  Platform,
  NativeModules,
  TouchableOpacity
} from 'react-native';

const onClickWelcomeButton = () => {
  if(Platform.OS === 'android'){
    NativeModules.ExpensesModule.show() 
  } else {
    Alert.alert(
      'Ouch!',
      "Looks like, this feature is not available on iOS",
      [
        {text: 'OK', onPress: () => console.log('OK Pressed'), style: 'default'},
      ],
      {cancelable: true},
    );
  }
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
    justifyContent: "center",
    backgroundColor: "#FFFFFF"
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