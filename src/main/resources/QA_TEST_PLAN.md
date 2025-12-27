# Mod QA Test Plan: Stormbinder Wand

**Mod ID:** `stormbinderwand`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-27T13:29:56.092Z
**Total Tests:** 2

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p stormbinderwand:lightning_wand
```

## Items

### 🤖 Lightning Wand Registration

**Command:** `/give @p stormbinderwand:lightning_wand`

**Steps:**
1. Run: /give @p stormbinderwand:lightning_wand
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Lightning Wand Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:diamond","minecraft:stick"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Lightning Wand

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 1 | [ ] | [ ] |
| Recipes | 1 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_