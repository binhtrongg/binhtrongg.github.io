package tech_shop.backend.database;

import tech_shop.backend.model.Epay;
import tech_shop.backend.utils.FileUtils;

import java.util.List;

public class EpayDataBase {
public static List<Epay>epays= FileUtils.getEpayFromFile("epay.json");
}
