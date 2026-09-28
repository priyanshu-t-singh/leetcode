#!/bin/bash

# Define the base directories
SRC_BASE="Data Structures & Algorithms"
DEST_BASE="Neetcode"

# Check if the script is being run from the correct root directory
if [[ ! -d "$SRC_BASE" ]]; then
    echo "❌ Error: '$SRC_BASE' directory not found."
    echo "Please run this script from the root of your project."
    exit 1
fi

# Get arguments
SECTION=$1
QUESTION=$2

# Prompt for usage if arguments are missing
if [[ -z "$QUESTION" || -z "$SECTION" ]]; then
    echo "Usage: ./make_link.sh \"<Section Folder>\" \"<Question Folder>\""
    echo "Example: ./make_link.sh \"14. Greedy\" \"763. Partition Labels\""
    exit 1
fi

# Construct full paths
SOURCE_PATH="$SRC_BASE/$QUESTION"
DEST_PATH="$DEST_BASE/$SECTION"

# Verify the target question actually exists
if [[ ! -d "$SOURCE_PATH" && ! -f "$SOURCE_PATH" ]]; then
    echo "❌ Error: Source '$SOURCE_PATH' does not exist!"
    exit 1
fi

# Ensure the destination section directory exists (creates it if it doesn't)
mkdir -p "$DEST_PATH"

# Format the symlink name: 
# This removes leading numbers, dots, and spaces (e.g., "763. Partition Labels" -> "Partition Labels")
LINK_NAME=$(echo "$QUESTION" | sed -E 's/^[0-9]+[.][[:space:]]*//')
FINAL_DEST="$DEST_PATH/$LINK_NAME"

# Create the symlink using -s (symbolic), -r (relative path calculation), -f (force overwrite if exists)
ln -srf "$SOURCE_PATH" "$FINAL_DEST"

echo "✅ Successfully created symlink!"
echo "📍 Location: $FINAL_DEST"
echo "🔗 Points to: $SOURCE_PATH (Relative path automatically calculated)"
